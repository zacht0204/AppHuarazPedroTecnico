
package com.huaraz.luis.apphuarazTecnico.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example2 {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("founded")
    @Expose
    private Integer founded;
    @SerializedName("lost_pet_id")
    @Expose
    private Integer lostPetId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public Integer getLostPetId() {
        return lostPetId;
    }

    public void setLostPetId(Integer lostPetId) {
        this.lostPetId = lostPetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
