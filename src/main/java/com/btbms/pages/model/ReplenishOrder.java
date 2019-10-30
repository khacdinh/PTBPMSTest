package com.btbms.pages.model;

import com.btbms.pages.enums.HandlingSuggestionType;
import com.btbms.pages.enums.OrderStatus;
import com.btbms.pages.enums.OrderType;

public class ReplenishOrder {
    private String replenishOrderNo;
    private OrderType orderType;
    private String businessGroup;
    private String clothType;
    private String clothSpecification;
    private String finishProductSpecification;
    private String stitchPerInch;
    private String lotNo;
    private String colorCodeInChinese;
    private String SAPCPONo;
    private String SAPMONo;
    private String itemNoOfMaterial;
    private String materialDescription;
    private String unitOfMeasure;
    private String finishProductQuantity;
    private String WIPLocation;
    private HandlingSuggestionType handlingSuggestionType;
    private OrderStatus orderStatus;

    private String registerUser;
    private String orderCreationDate;
    private String sAPSalesOrderNo;
    private String customerNo;


    private ResponseDept responseDept1;
    private ResponseDept responseDept2;
    private String orderReason;
    private String orderProcess;

    public String getReplenishOrderNo() {
        return replenishOrderNo;
    }

    public void setReplenishOrderNo(String replenishOrderNo) {
        this.replenishOrderNo = replenishOrderNo;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getBusinessGroup() {
        return businessGroup;
    }

    public void setBusinessGroup(String businessGroup) {
        this.businessGroup = businessGroup;
    }

    public String getClothType() {
        return clothType;
    }

    public void setClothType(String clothType) {
        this.clothType = clothType;
    }

    public String getClothSpecification() {
        return clothSpecification;
    }

    public void setClothSpecification(String clothSpecification) {
        this.clothSpecification = clothSpecification;
    }

    public String getFinishProductSpecification() {
        return finishProductSpecification;
    }

    public void setFinishProductSpecification(String finishProductSpecification) {
        this.finishProductSpecification = finishProductSpecification;
    }

    public String getStitchPerInch() {
        return stitchPerInch;
    }

    public void setStitchPerInch(String stitchPerInch) {
        this.stitchPerInch = stitchPerInch;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getColorCodeInChinese() {
        return colorCodeInChinese;
    }

    public void setColorCodeInChinese(String colorCodeInChinese) {
        this.colorCodeInChinese = colorCodeInChinese;
    }

    public String getSAPCPONo() {
        return SAPCPONo;
    }

    public void setSAPCPONo(String SAPCPONo) {
        this.SAPCPONo = SAPCPONo;
    }

    public String getSAPMONo() {
        return SAPMONo;
    }

    public void setSAPMONo(String SAPMONo) {
        this.SAPMONo = SAPMONo;
    }

    public String getItemNoOfMaterial() {
        return itemNoOfMaterial;
    }

    public void setItemNoOfMaterial(String itemNoOfMaterial) {
        this.itemNoOfMaterial = itemNoOfMaterial;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getFinishProductQuantity() {
        return finishProductQuantity;
    }

    public void setFinishProductQuantity(String finishProductQuantity) {
        this.finishProductQuantity = finishProductQuantity;
    }

    public String getWIPLocation() {
        return WIPLocation;
    }

    public void setWIPLocation(String WIPLocation) {
        this.WIPLocation = WIPLocation;
    }

    public HandlingSuggestionType getHandlingSuggestionType() {
        return handlingSuggestionType;
    }

    public void setHandlingSuggestionType(HandlingSuggestionType handlingSuggestionType) {
        this.handlingSuggestionType = handlingSuggestionType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    public String getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(String orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public String getsAPSalesOrderNo() {
        return sAPSalesOrderNo;
    }

    public void setsAPSalesOrderNo(String sAPSalesOrderNo) {
        this.sAPSalesOrderNo = sAPSalesOrderNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public ResponseDept getResponseDept1() {
        return responseDept1;
    }

    public void setResponseDept1(ResponseDept responseDept1) {
        this.responseDept1 = responseDept1;
    }

    public ResponseDept getResponseDept2() {
        return responseDept2;
    }

    public void setResponseDept2(ResponseDept responseDept2) {
        this.responseDept2 = responseDept2;
    }

    public String getOrderReason() {
        return orderReason;
    }

    public void setOrderReason(String orderReason) {
        this.orderReason = orderReason;
    }

    public String getOrderProcess() {
        return orderProcess;
    }

    public void setOrderProcess(String orderProcess) {
        this.orderProcess = orderProcess;
    }


    public static final class ReplenishOrderBuilder {
        private String replenishOrderNo;
        private OrderType orderType;
        private String businessGroup;
        private String clothType;
        private String clothSpecification;
        private String finishProductSpecification;
        private String stitchPerInch;
        private String lotNo;
        private String colorCodeInChinese;
        private String SAPCPONo;
        private String SAPMONo;
        private String itemNoOfMaterial;
        private String materialDescription;
        private String unitOfMeasure;
        private String finishProductQuantity;
        private String WIPLocation;
        private HandlingSuggestionType handlingSuggestionType;
        private OrderStatus orderStatus;
        private String registerUser;
        private String orderCreationDate;
        private String sAPSalesOrderNo;
        private String customerNo;
        private ResponseDept responseDept1;
        private ResponseDept responseDept2;
        private String orderReason;
        private String orderProcess;

        private ReplenishOrderBuilder() {
        }

        public static ReplenishOrderBuilder aReplenishOrder() {
            return new ReplenishOrderBuilder();
        }

        public ReplenishOrderBuilder withReplenishOrderNo(String replenishOrderNo) {
            this.replenishOrderNo = replenishOrderNo;
            return this;
        }

        public ReplenishOrderBuilder withOrderType(OrderType orderType) {
            this.orderType = orderType;
            return this;
        }

        public ReplenishOrderBuilder withBusinessGroup(String businessGroup) {
            this.businessGroup = businessGroup;
            return this;
        }

        public ReplenishOrderBuilder withClothType(String clothType) {
            this.clothType = clothType;
            return this;
        }

        public ReplenishOrderBuilder withClothSpecification(String clothSpecification) {
            this.clothSpecification = clothSpecification;
            return this;
        }

        public ReplenishOrderBuilder withFinishProductSpecification(String finishProductSpecification) {
            this.finishProductSpecification = finishProductSpecification;
            return this;
        }

        public ReplenishOrderBuilder withStitchPerInch(String stitchPerInch) {
            this.stitchPerInch = stitchPerInch;
            return this;
        }

        public ReplenishOrderBuilder withLotNo(String lotNo) {
            this.lotNo = lotNo;
            return this;
        }

        public ReplenishOrderBuilder withColorCodeInChinese(String colorCodeInChinese) {
            this.colorCodeInChinese = colorCodeInChinese;
            return this;
        }

        public ReplenishOrderBuilder withSAPCPONo(String SAPCPONo) {
            this.SAPCPONo = SAPCPONo;
            return this;
        }

        public ReplenishOrderBuilder withSAPMONo(String SAPMONo) {
            this.SAPMONo = SAPMONo;
            return this;
        }

        public ReplenishOrderBuilder withItemNoOfMaterial(String itemNoOfMaterial) {
            this.itemNoOfMaterial = itemNoOfMaterial;
            return this;
        }

        public ReplenishOrderBuilder withMaterialDescription(String materialDescription) {
            this.materialDescription = materialDescription;
            return this;
        }

        public ReplenishOrderBuilder withUnitOfMeasure(String unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
            return this;
        }

        public ReplenishOrderBuilder withFinishProductQuantity(String finishProductQuantity) {
            this.finishProductQuantity = finishProductQuantity;
            return this;
        }

        public ReplenishOrderBuilder withWIPLocation(String WIPLocation) {
            this.WIPLocation = WIPLocation;
            return this;
        }

        public ReplenishOrderBuilder withHandlingSuggestionType(HandlingSuggestionType handlingSuggestionType) {
            this.handlingSuggestionType = handlingSuggestionType;
            return this;
        }

        public ReplenishOrderBuilder withOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public ReplenishOrderBuilder withRegisterUser(String registerUser) {
            this.registerUser = registerUser;
            return this;
        }

        public ReplenishOrderBuilder withOrderCreationDate(String orderCreationDate) {
            this.orderCreationDate = orderCreationDate;
            return this;
        }

        public ReplenishOrderBuilder withSAPSalesOrderNo(String sAPSalesOrderNo) {
            this.sAPSalesOrderNo = sAPSalesOrderNo;
            return this;
        }

        public ReplenishOrderBuilder withCustomerNo(String customerNo) {
            this.customerNo = customerNo;
            return this;
        }

        public ReplenishOrderBuilder withResponseDept1(ResponseDept responseDept1) {
            this.responseDept1 = responseDept1;
            return this;
        }

        public ReplenishOrderBuilder withResponseDept2(ResponseDept responseDept2) {
            this.responseDept2 = responseDept2;
            return this;
        }

        public ReplenishOrderBuilder withOrderReason(String orderReason) {
            this.orderReason = orderReason;
            return this;
        }

        public ReplenishOrderBuilder withOrderProcess(String orderProcess) {
            this.orderProcess = orderProcess;
            return this;
        }

        public ReplenishOrder build() {
            ReplenishOrder replenishOrder = new ReplenishOrder();
            replenishOrder.setReplenishOrderNo(replenishOrderNo);
            replenishOrder.setOrderType(orderType);
            replenishOrder.setBusinessGroup(businessGroup);
            replenishOrder.setClothType(clothType);
            replenishOrder.setClothSpecification(clothSpecification);
            replenishOrder.setFinishProductSpecification(finishProductSpecification);
            replenishOrder.setStitchPerInch(stitchPerInch);
            replenishOrder.setLotNo(lotNo);
            replenishOrder.setColorCodeInChinese(colorCodeInChinese);
            replenishOrder.setSAPCPONo(SAPCPONo);
            replenishOrder.setSAPMONo(SAPMONo);
            replenishOrder.setItemNoOfMaterial(itemNoOfMaterial);
            replenishOrder.setMaterialDescription(materialDescription);
            replenishOrder.setUnitOfMeasure(unitOfMeasure);
            replenishOrder.setFinishProductQuantity(finishProductQuantity);
            replenishOrder.setWIPLocation(WIPLocation);
            replenishOrder.setHandlingSuggestionType(handlingSuggestionType);
            replenishOrder.setOrderStatus(orderStatus);
            replenishOrder.setRegisterUser(registerUser);
            replenishOrder.setOrderCreationDate(orderCreationDate);
            replenishOrder.setCustomerNo(customerNo);
            replenishOrder.setResponseDept1(responseDept1);
            replenishOrder.setResponseDept2(responseDept2);
            replenishOrder.setOrderReason(orderReason);
            replenishOrder.setOrderProcess(orderProcess);
            replenishOrder.sAPSalesOrderNo = this.sAPSalesOrderNo;
            return replenishOrder;
        }
    }
}
