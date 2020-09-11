package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.media.request.*;
import be.fooda.backend.commons.model.template.media.response.*;

public class FoodaMediaProductHttpMapper implements FoodaHttpMapper<FoodaMediaProductReq, FoodaMediaProductRes> {
    @Override
    public FoodaMediaProductReq responseToRequest(FoodaMediaProductRes foodaMediaProductRes) {
        return  FoodaMediaProductReq.builder()
                .product(productInfo(foodaMediaProductRes))
                .url(foodaMediaProductRes.getUrl())
                .store(storeReq(foodaMediaProductRes))
                .type(mediaType(foodaMediaProductRes))
                .productMediaId(foodaMediaProductRes.getProductMediaId())
                .build();
    }
    private FoodaMediaTypeReq mediaType(FoodaMediaProductRes res) {
        return FoodaMediaTypeReq.builder()
                .extension(res.getType().getExtension())
                .title(res.getType().getTitle())
                .typeId(res.getType().getTypeId())
                .build();
    }

    private FoodaMediaStoreReq storeReq(FoodaMediaProductRes res) {
        return FoodaMediaStoreReq.builder()
                .store(mediaStoreInfo(res))
                .storeMediaId(res.getStore().getStoreMediaId())
                .url(res.getUrl())
                .type(mediaType(res))
                .build();
    }

    private FoodaMediaStoreInfoReq mediaStoreInfo(FoodaMediaProductRes res) {
        return FoodaMediaStoreInfoReq.builder()
                .name(res.getProduct().getName())
                .storeId(res.getStore().getStore().getStoreId())
                .build();
    }

    private FoodaMediaProductInfoReq productInfo(FoodaMediaProductRes res) {
        return FoodaMediaProductInfoReq.builder()
                .productId(res.getProduct().getProductId())
                .name(res.getProduct().getName())
                .build();
    }

    @Override
    public FoodaMediaProductRes requestToResponse(FoodaMediaProductReq foodaMediaProductReq) {
        final FoodaMediaProductRes mediaProductRes=new FoodaMediaProductRes();
        mediaProductRes.setUrl(foodaMediaProductReq.getUrl());
        mediaProductRes.setProductMediaId(foodaMediaProductReq.getProductMediaId());
        mediaProductRes.setProduct(productInfoRes(foodaMediaProductReq));
        mediaProductRes.setType(mediaTypeRes(foodaMediaProductReq));
        mediaProductRes.setStore(mediaStoreRes(foodaMediaProductReq));
        return mediaProductRes;

    }
    private FoodaMediaStoreRes mediaStoreRes(FoodaMediaProductReq req) {
        final FoodaMediaStoreRes mediaStoreRes=new FoodaMediaStoreRes();
        mediaStoreRes.setType(mediaTypeRes(req));
        mediaStoreRes.setStore(mediaStoreInfoRes(req));
        mediaStoreRes.setStoreMediaId(req.getStore().getStoreMediaId());
        mediaStoreRes.setUrl(req.getUrl());
        return mediaStoreRes;
    }
    private FoodaMediaStoreInfoRes mediaStoreInfoRes(FoodaMediaProductReq req) {
        final FoodaMediaStoreInfoRes mediaStoreInfoRes=new FoodaMediaStoreInfoRes();
        mediaStoreInfoRes.setName(req.getStore().getStore().getName());
        mediaStoreInfoRes.setStoreId(req.getStore().getStore().getStoreId());

        return mediaStoreInfoRes;
    }
    private FoodaMediaTypeRes mediaTypeRes(FoodaMediaProductReq req) {
        final FoodaMediaTypeRes mediaTypeRes=new FoodaMediaTypeRes();
        mediaTypeRes.setTypeId(req.getType().getTypeId());
        mediaTypeRes.setTitle(req.getType().getTitle());
        mediaTypeRes.setExtension(req.getType().getExtension());

        return mediaTypeRes;
    }
    private FoodaMediaProductInfoRes productInfoRes(FoodaMediaProductReq req) {
        final FoodaMediaProductInfoRes mediaProductInfoRes=new FoodaMediaProductInfoRes();
        mediaProductInfoRes.setName(req.getProduct().getName());
        mediaProductInfoRes.setProductId(req.getProduct().getProductId());
        return mediaProductInfoRes;
    }
}
