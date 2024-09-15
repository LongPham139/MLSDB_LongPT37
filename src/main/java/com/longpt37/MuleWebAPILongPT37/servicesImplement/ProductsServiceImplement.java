package com.longpt37.MuleWebAPILongPT37.servicesImplement;

import com.longpt37.MuleWebAPILongPT37.dto.Products;
import com.longpt37.MuleWebAPILongPT37.dto.PurchaseOrderDetails;
import com.longpt37.MuleWebAPILongPT37.dto.ResponseDTO;
import com.longpt37.MuleWebAPILongPT37.dto.SalesOrderDetails;
import com.longpt37.MuleWebAPILongPT37.repository.ProductRepository;
import com.longpt37.MuleWebAPILongPT37.repository.PurchaseOrderDetailsRepository;
import com.longpt37.MuleWebAPILongPT37.repository.SalesOrderDetailRepository;
import com.longpt37.MuleWebAPILongPT37.request.ProductRequest;
import com.longpt37.MuleWebAPILongPT37.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImplement implements ProductsService {
    private final ProductRepository productRepository;
    private final PurchaseOrderDetailsRepository purchaseOrderDetailsRepository;
    private final SalesOrderDetailRepository salesOrderDetailRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");

    @Override
    public List<Products> getAllProducts() {
        List<Products> list = productRepository.getAll();
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    @Override
    public ResponseDTO<Products> insertProducts(ProductRequest products) throws ParseException {
        ResponseDTO<Products> responseDTO = new ResponseDTO<>();
        Products temp = productRepository.findByProductCodeAnd(products.getProductCode(), products.getUnitPrice());
        if (temp != null) {
            responseDTO.setStatus("500");
            responseDTO.setData(temp);
            responseDTO.setMessage("Insert fail!!!");
            return responseDTO;
        }
        temp = Products.builder()
                .productCode(products.getProductCode())
                .productName(products.getProductName())
                .quantityInStock(products.getQuantityInStock())
                .unitPrice(products.getUnitPrice())
                .createdDate(new Date(formatter.parse(products.getCreatedDate()).getTime()))
                .createdBy(products.getCreatedBy())
                .unit(products.getUnit())
                .build();
        productRepository.save(temp);
        responseDTO.setStatus("200");
        responseDTO.setData(temp);
        responseDTO.setMessage("Insert Success!!!");
        return responseDTO;
    }

    @Override
    public ResponseDTO<Products> updatePODProduct(String productCode, String orderNo, double quantityInStock) {
        ResponseDTO<Products> responseDTO = new ResponseDTO<>();
        Products temp = productRepository.findByProductCode(productCode);
        PurchaseOrderDetails tmpPOD = purchaseOrderDetailsRepository.findByOrderNo(orderNo);
        if (temp == null && tmpPOD == null) {
            responseDTO.setStatus("500");
            responseDTO.setData(temp);
            responseDTO.setMessage("Update fail!!!");
            return responseDTO;
        }
        double tmpQuantityInStock = quantityInStock + 5;
        double tmpUnitPrice = (tmpQuantityInStock * temp.getUnitPrice() + tmpPOD.getQuantity() * tmpPOD.getPurchasePrice()) / 2;
        temp.setQuantityInStock(tmpQuantityInStock);
        temp.setUnitPrice(tmpUnitPrice);
        productRepository.save(temp);
        responseDTO.setStatus("200");
        responseDTO.setData(temp);
        responseDTO.setMessage("Update Success!!!");
        return responseDTO;
    }

    @Override
    public ResponseDTO<Products> updateSODProduct(String productCode, String orderNo, double quantityInStock) {
        ResponseDTO<Products> responseDTO = new ResponseDTO<>();
        Products temp = productRepository.findByProductCode(productCode);
        SalesOrderDetails tmpSOD = salesOrderDetailRepository.findByOrderNo(orderNo);
        if (temp == null && tmpSOD == null) {
            responseDTO.setStatus("500");
            responseDTO.setData(temp);
            responseDTO.setMessage("Update fail!!!");
            return responseDTO;
        }
        double totalQuantity = temp.getQuantityInStock() - tmpSOD.getQuantity();
        temp.setQuantityInStock(totalQuantity);
        productRepository.save(temp);
        responseDTO.setStatus("200");
        responseDTO.setData(temp);
        responseDTO.setMessage("Update Success!!!");
        return responseDTO;
    }
}
