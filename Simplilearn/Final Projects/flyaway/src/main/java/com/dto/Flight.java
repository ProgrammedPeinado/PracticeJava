package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avail_flights")
public class Flight 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="flight_id")
	private Integer id;
	@Column(name="src_point")
	private String source;
	@Column(name="dest_point")
	private String destination;
	@Column(name="travel_date")
	private String date;
	@Column(name="time_to_board")
	private String time;
	@Column(name="price")
	private Double price;
	@Column(name="seat_vacancy")
	private Integer seats;
	
	public Flight()
	{
	}
	
	public Flight(String id, String source, String destination, String date, String time, String price, String seats)
	{
		super();
		this.id = Integer.parseInt(id);
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.price = Double.parseDouble(price);
		this.seats = Integer.parseInt(seats);
	}
	
	public Flight(String id, String source, String destination, String seats, String date)
	{
		super();
		this.source = source;
		this.destination = destination;
		this.seats = Integer.parseInt(seats);
		this.date = date;
	}
	
	public Flight(String source, String destination, String seats, String date)
	{
		super();
		this.source = source;
		this.destination = destination;
		this.seats = Integer.parseInt(seats);
		this.date = date;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", source=" + source + ", destination=" + destination + ", date=" + date + ", time="
				+ time + ", price=" + price + "]";
	}
}
