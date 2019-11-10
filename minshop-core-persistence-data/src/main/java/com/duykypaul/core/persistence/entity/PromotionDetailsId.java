package com.duykypaul.core.persistence.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PromotionDetailsId implements Serializable {
    Integer promotion_id;
    Integer product_id;

    public Integer getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Integer promotion_id) {
        this.promotion_id = promotion_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public PromotionDetailsId(Integer promotion_id, Integer product_id) {
        this.promotion_id = promotion_id;
        this.product_id = product_id;
    }
}
