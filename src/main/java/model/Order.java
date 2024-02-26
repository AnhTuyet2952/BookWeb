package model;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private User user;
    private double totalPrice;
    private String nameConsignee;
    private String phone;
    private String email;
    private String address;
    private Payment payment;
    private String status;
    private Date bookingDate;
    private String note;
    private List<OrderDetail> orderDetailList;

    public Order(int orderId, User user, double totalPrice, String nameConsignee, String phone, String email, String address, Payment payment, String status, Date bookingDate, String note, List<OrderDetail> orderDetailList) {
        this.orderId = orderId;
        this.user = user;
        this.totalPrice = totalPrice;
        this.nameConsignee = nameConsignee;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.payment = payment;
        this.status = status;
        this.bookingDate = bookingDate;
        this.note = note;
        this.orderDetailList = orderDetailList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNameConsignee() {
        return nameConsignee;
    }

    public void setNameConsignee(String nameConsignee) {
        this.nameConsignee = nameConsignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
