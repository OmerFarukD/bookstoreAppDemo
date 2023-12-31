package com.kodluyoruz.bookstoreappdemo.Core.Results;

// Jenerikler
// List<ProductResponseDto>
// ProductResponseDto
//String
public abstract class DataResult<T> extends Result{
    // productList
// DataResult<List<ProductResponseDto>>
    private T data;
    public DataResult(boolean success) {
        super(success);
    }

    public DataResult(boolean success, String message) {
        super(success, message);
    }

    public DataResult(boolean success,T data,String message){
        super(success,message);
        this.data=data;
    }

    public DataResult(boolean success, T data){
        super(success);
        this.data=data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
