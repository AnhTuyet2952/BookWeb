package model;

import java.util.Date;

public class Comment {
    private Product product;
    private User user;
    private String detailComment;
    private Date dateComment;

    public Comment(Product product, User user, String detailComment, Date dateComment) {
        this.product = product;
        this.user = user;
        this.detailComment = detailComment;
        this.dateComment = dateComment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDetailComment() {
        return detailComment;
    }

    public void setDetailComment(String detailComment) {
        this.detailComment = detailComment;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }
}
