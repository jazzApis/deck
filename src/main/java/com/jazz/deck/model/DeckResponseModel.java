package com.jazz.deck.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeckResponseModel {

	//////////////////////////////////////
	//			  Fields			   //
	////////////////////////////////////

	// success indicator
	private Boolean success;
	
	// error code & message
	private Integer code;
	private String message;
	
	// response data
	private List<Object> items;
	private Object item;

	//////////////////////////////////////
	//			Constructors		   //
	////////////////////////////////////
	/**
	 * Default constructor
	 */
	public DeckResponseModel() {
		// for JSON
	}
	
	/**
	 * For builder
	 * @param builder String
	 */
	private DeckResponseModel(Builder builder) {
		this.success = builder.success;
		this.code = builder.code;
		this.message= builder.message;
		this.item = builder.item;
		this.items = builder.items;
	}
	
	//////////////////////////////////////
	//				Builder		   	   //
	////////////////////////////////////
	/**
	 * Creates builder to build {@link DeckResponseModel}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link DeckResponseModel}.
	 */
	public static final class Builder {
		private Boolean success;
		private Integer code;
		private String message;
		private List<Object> items;
		private Object item;

		private Builder() {
			success = true;
		}

		public Builder withSuccess(Boolean success) {
			this.success = success;
			return this;
		}

		public Builder withException(Exception exception) {
			this.success = false;
			this.code = 500;
			this.message= exception.getMessage();
			return this;
		}

		public Builder withCode(Integer code) {
			this.code = code;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		@SuppressWarnings("unchecked")
		public Builder withItems(List<?> items) {
			this.items = (List<Object>)items;
			return this;
		}

		public Builder withItem(Object item) {
			this.item = item;
			return this;
		}

		public DeckResponseModel build() {
			return new DeckResponseModel(this);
		}
	}

	//////////////////////////////////////
	//		  Getters && Setters	   //
	////////////////////////////////////
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "DeckResponseModel [success=" + success + ", code=" + code + ", message=" + message + ", items=" + items
				+ ", item=" + item + "]";
	}
}