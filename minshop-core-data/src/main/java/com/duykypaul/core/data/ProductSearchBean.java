package com.duykypaul.core.data;


public class ProductSearchBean {
    private String nameProduct;
    private Integer priceFrom;
    private Integer priceTo;
    private Integer pageNumber;
    private Integer maxResult;
    public Integer getMaxResult() {
        return maxResult;
    }
    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }
    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Integer priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Integer getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Integer priceTo) {
        this.priceTo = priceTo;
    }
}
