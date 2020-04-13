package it.vkod.woo.product.service.payloads.orderResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Shipping{

	@JsonProperty("country")
	private String country;

	@JsonProperty("city")
	private String city;

	@JsonProperty("address_1")
	private String address1;

	@JsonProperty("address_2")
	private String address2;

	@JsonProperty("postcode")
	private String postcode;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("company")
	private String company;

	@JsonProperty("state")
	private String state;

	@JsonProperty("first_name")
	private String firstName;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setAddress1(String address1){
		this.address1 = address1;
	}

	public String getAddress1(){
		return address1;
	}

	public void setAddress2(String address2){
		this.address2 = address2;
	}

	public String getAddress2(){
		return address2;
	}

	public void setPostcode(String postcode){
		this.postcode = postcode;
	}

	public String getPostcode(){
		return postcode;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	@Override
 	public String toString(){
		return 
			"Shipping{" + 
			"country = '" + country + '\'' + 
			",city = '" + city + '\'' + 
			",address_1 = '" + address1 + '\'' + 
			",address_2 = '" + address2 + '\'' + 
			",postcode = '" + postcode + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",company = '" + company + '\'' + 
			",state = '" + state + '\'' + 
			",first_name = '" + firstName + '\'' + 
			"}";
		}
}