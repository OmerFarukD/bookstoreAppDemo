package com.kodluyoruz.bookstoreappdemo.Service.Contrats;

import com.kodluyoruz.bookstoreappdemo.Core.Results.DataResult;
import com.kodluyoruz.bookstoreappdemo.Core.Results.Result;

import java.util.List;

public interface BaseService<TAdd,TUpdate, TResponse> {

    Result add(TAdd request);
    DataResult<List<TResponse>> getAll();
    Result update(TUpdate update);
    Result delete(int id);
    DataResult<TResponse> getById(int id);

}
