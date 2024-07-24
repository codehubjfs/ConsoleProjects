package com.hallbookingmanagement.beans;

public class Feedback {
	private int feedbackId;
	private Booking book;
	private int rating;
	private String feedback;
	
	public Feedback() {
	}
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Booking getBook() {
		return book;
	}
	public void setBook(Booking book) {
		this.book = book;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
