package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaStoreInfoReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaStoreReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaTypeReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaStoreInfoRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaStoreRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaTypeRes;

public class FoodaMediaStoreHttpMapper implements FoodaHttpMapper<FoodaMediaStoreReq, FoodaMediaStoreRes> {
    @Override
    public FoodaMediaStoreReq responseToRequest(FoodaMediaStoreRes foodaMediaStoreRes) {
        return FoodaMediaStoreReq.builder()
                .storeMediaId(foodaMediaStoreRes.getStoreMediaId())
                .url(foodaMediaStoreRes.getUrl())
                .store(mediaStoreInfoReq(foodaMediaStoreRes))
                .type(mediaTypeReq(foodaMediaStoreRes))
                .build();
    }

    private FoodaMediaTypeReq mediaTypeReq(FoodaMediaStoreRes foodaMediaStoreRes) {
        return FoodaMediaTypeReq.builder()
                .typeId(foodaMediaStoreRes.getType().getTypeId())
                .extension(foodaMediaStoreRes.getType().getExtension())
                .title(foodaMediaStoreRes.getType().getTitle())
                .build();
    }

    private FoodaMediaStoreInfoReq mediaStoreInfoReq(FoodaMediaStoreRes foodaMediaStoreRes) {
        return FoodaMediaStoreInfoReq.builder()
                .storeId(foodaMediaStoreRes.getStore().getStoreId())
                .name(foodaMediaStoreRes.getStore().getName())
                .build();
    }

    @Override
    public FoodaMediaStoreRes requestToResponse(FoodaMediaStoreReq foodaMediaStoreReq) {
         FoodaMediaStoreRes foodaMediaStoreRes=new FoodaMediaStoreRes();
        foodaMediaStoreRes.setStoreMediaId(foodaMediaStoreReq.getStoreMediaId());
        foodaMediaStoreRes.setUrl(foodaMediaStoreReq.getUrl());
        foodaMediaStoreRes.setStore(mediaStoreInfoRes(foodaMediaStoreReq));
        foodaMediaStoreRes.setType(mediaTypeRes(foodaMediaStoreReq));

        return foodaMediaStoreRes;
    }

    private FoodaMediaTypeRes mediaTypeRes(FoodaMediaStoreReq foodaMediaStoreReq) {
         FoodaMediaTypeRes foodaMediaTypeRes=new FoodaMediaTypeRes();
        foodaMediaTypeRes.setTypeId(foodaMediaStoreReq.getType().getTypeId());
         foodaMediaTypeRes.setExtension(foodaMediaStoreReq.getType().getExtension());
        foodaMediaTypeRes.setTitle(foodaMediaStoreReq.getType().getTitle());
        return foodaMediaTypeRes;
    }

    private FoodaMediaStoreInfoRes mediaStoreInfoRes(FoodaMediaStoreReq foodaMediaStoreReq) {
        FoodaMediaStoreInfoRes foodaMediaStoreInfoRes=new FoodaMediaStoreInfoRes();
        foodaMediaStoreInfoRes.setStoreId(foodaMediaStoreReq.getStore().getStoreId());
        foodaMediaStoreInfoRes.setName(foodaMediaStoreReq.getStore().getName());
        return foodaMediaStoreInfoRes;
    }
}
