package com.kodluyoruz.bookstoreappdemo.Core.Results;

public class ErrorResult extends Result{
    public ErrorResult() {
        super(false);
    }
    public ErrorResult(String message) {
        super(false, message);
    }
}