package com.example.finalandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("LoaiSp")
    @Expose
    private String loaiSp;
    @SerializedName("TenSp")
    @Expose
    private String tenSp;
    @SerializedName("GiaSp")
    @Expose
    private String giaSp;
    @SerializedName("NgayThemSp")
    @Expose
    private String ngayThemSp;
    @SerializedName("MoTaSp")
    @Expose
    private String moTaSp;
    @SerializedName("Images")
    @Expose
    private String images;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(String giaSp) {
        this.giaSp = giaSp;
    }

    public String getNgayThemSp() {
        return ngayThemSp;
    }

    public void setNgayThemSp(String ngayThemSp) {
        this.ngayThemSp = ngayThemSp;
    }

    public String getMoTaSp() {
        return moTaSp;
    }

    public void setMoTaSp(String moTaSp) {
        this.moTaSp = moTaSp;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}