package com.duykypaul.core.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name="promotion_details")
public class PromotionDetails {
    @EmbeddedId
    PromotionDetailsId promotionDetailsId;

    public PromotionDetailsId getPromotionDetailsId() {
        return promotionDetailsId;
    }

    public void setPromotionDetailsId(PromotionDetailsId promotionDetailsId) {
        this.promotionDetailsId = promotionDetailsId;
    }
}
