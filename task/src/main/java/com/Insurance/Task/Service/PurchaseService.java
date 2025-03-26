 package com.Insurance.Task.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.UUID;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import com.Insurance.Task.Model.Insurance;
import com.Insurance.Task.Model.Purchase;
import com.Insurance.Task.Repo.InsuranceRepository;
import com.Insurance.Task.Repo.PurchaseRepository;
import com.Insurance.Task.dto.PurchaseRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import java.nio.file.Path;
import java.nio.file.Files;

@Service
 public class PurchaseService {
     private final PurchaseRepository purchaseRepository;
     private final InsuranceRepository insuranceRepository;

     public PurchaseService(PurchaseRepository purchaseRepository, 
                           InsuranceRepository insuranceRepository) {
         this.purchaseRepository = purchaseRepository;
         this.insuranceRepository = insuranceRepository;
     }

     public Purchase createPurchase(PurchaseRequest request) {
         Insurance insurance = insuranceRepository.findById(request.getInsuranceId())
             .orElseThrow(() -> new RuntimeException("Insurance not found"));
         
         Purchase purchase = new Purchase();
         purchase.setUserId(request.getUserId());
         purchase.setInsuranceId(request.getInsuranceId());
         purchase.setPurchaseDate(LocalDate.now());
         purchase.setPolicyDocumentPath(generatePolicyPath());
         
         return purchaseRepository.save(purchase);
     }

     public Resource getPolicyDocument(Long purchaseId) {
         Purchase purchase = purchaseRepository.findById(purchaseId)
             .orElseThrow(() -> new RuntimeException("Purchase not found"));
         
         try {
             // Implement your PDF generation logic here
             return generateDummyPolicy(purchase);
         } catch (IOException e) {
             throw new RuntimeException("Error generating policy document");
         }
     }

     private String generatePolicyPath() {
         return "/policies/policy-" + UUID.randomUUID() + ".pdf";
     }

     private Resource generateDummyPolicy(Purchase purchase) throws IOException {
    	    // Create document and page
    	    PDDocument document = new PDDocument();
    	    PDPage page = new PDPage(PDRectangle.A4);  // Explicit page size
    	    document.addPage(page);

    	    // Get page dimensions
    	    PDRectangle mediaBox = page.getMediaBox();
    	    float margin = 50;
    	    float startX = mediaBox.getLowerLeftX() + margin;
    	    float startY = mediaBox.getUpperRightY() - margin;

    	    try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
    	        // Set font and size
    	        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
    	        
    	        // Begin text and set position
    	        contentStream.beginText();
    	        contentStream.newLineAtOffset(startX, startY);
    	        
    	        // Add text content
    	        contentStream.showText("Insurance Policy Document");
    	        contentStream.newLineAtOffset(0, -20);  // Move down
    	        contentStream.showText("Purchase ID: " + purchase.getId());
    	        contentStream.newLineAtOffset(0, -20);
    	        contentStream.showText("User ID: " + purchase.getUserId());
    	        contentStream.newLineAtOffset(0, -20);
    	        contentStream.showText("Date: " + LocalDate.now());
    	        
    	        contentStream.endText();
    	        
    	        // Add a border rectangle for visibility
    	        contentStream.addRect(margin, margin, 
    	                            mediaBox.getWidth() - 2*margin, 
    	                            mediaBox.getHeight() - 2*margin);
    	        contentStream.stroke();
    	    }

    	    // Verify PDF content by saving to temp file
    	    Path tempFile = Files.createTempFile("policy-", ".pdf");
    	    document.save(tempFile.toFile());
    	    document.close();
    	    
    	    // Debug: Print file location
    	    System.out.println("PDF generated at: " + tempFile.toAbsolutePath());
    	    
    	    return new FileSystemResource(tempFile.toFile());
    	}
 }
