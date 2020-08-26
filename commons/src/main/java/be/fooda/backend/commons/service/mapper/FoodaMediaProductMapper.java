package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.media.dto.FoodaMediaProductDto;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaProductReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaProductRes;
import be.fooda.backend.commons.model.template.media.dto.FoodaMediaTypeDto;
import be.fooda.backend.commons.model.template.media.request.*;
import be.fooda.backend.commons.model.template.media.response.*;
import be.fooda.backend.commons.model.template.product.dto.FoodaProductKeyDto;

public class FoodaMediaProductMapper implements FoodaObjectMapper<FoodaMediaProductDto, FoodaMediaProductReq, FoodaMediaProductRes>{

    @Override
    public FoodaMediaProductReq dtoToRequest(FoodaMediaProductDto dto) {
        return FoodaMediaProductReq.builder()
                .productMediaId(dto.getProductMediaId())
                .product(product(dto))
                .url(dto.getUrl())
                .type(type(dto))
                .store(store(dto))
                .build();

    }

    private FoodaMediaProductInfoReq product(FoodaMediaProductDto dto) {
        return FoodaMediaProductInfoReq.builder()
                .productId(dto.getProductKey().getProductId())
                //.name(dto)
                .build();
    }

    private FoodaMediaStoreReq store(FoodaMediaProductDto dto) {
        return FoodaMediaStoreReq.builder()
                .store(storeInfo(dto))
                .url(dto.getUrl())
                .type(type(dto))
                //.storeMediaId(dto.getProductMediaId())
                .build();
    }

    private FoodaMediaStoreInfoReq storeInfo(FoodaMediaProductDto dto) {
        return FoodaMediaStoreInfoReq.builder()
                .storeId(dto.getProductKey().getStoreId())
                //.name(dto
                .build();
    }

    private FoodaMediaTypeReq type(FoodaMediaProductDto dto) {
        return FoodaMediaTypeReq.builder()
                .typeId(dto.getType().getTypeId())
                .title(dto.getType().getTitle())
                .extension(dto.getType().getExtension())
                .build();
    }

    @Override
    public FoodaMediaProductReq responseToRequest(FoodaMediaProductRes res) {
        return FoodaMediaProductReq.builder()
                .product(productInfo(res))
                .url(res.getUrl())
                .store(storeReq(res))
                .type(mediaType(res))
                .productMediaId(res.getProductMediaId())
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
    public FoodaMediaProductRes dtoToResponse(FoodaMediaProductDto dto) {
        final FoodaMediaProductRes mediaProductRes=new FoodaMediaProductRes();
        mediaProductRes.setProduct(productInfoRes(dto));
        mediaProductRes.setProductMediaId(dto.getProductMediaId());
        mediaProductRes.setStore(mediaStoreRes(dto));
        mediaProductRes.setType(mediaTypeRes(dto));
        mediaProductRes.setUrl(dto.getUrl());
        return mediaProductRes;
    }

    private FoodaMediaStoreRes mediaStoreRes(FoodaMediaProductDto dto) {
        final FoodaMediaStoreRes mediaStoreRes=new FoodaMediaStoreRes();
        mediaStoreRes.setUrl(dto.getUrl());
        mediaStoreRes.setStore(mediaStoreInfoRes(dto));
        mediaStoreRes.setType(mediaTypeRes(dto));
        return mediaStoreRes;
    }

    private FoodaMediaTypeRes mediaTypeRes(FoodaMediaProductDto dto) {
        final FoodaMediaTypeRes mediaTypeRes=new FoodaMediaTypeRes();
        mediaTypeRes.setExtension(dto.getType().getExtension());
        mediaTypeRes.setTitle(dto.getType().getTitle());
        mediaTypeRes.setTypeId(dto.getType().getTypeId());
        return mediaTypeRes;
    }

    private FoodaMediaStoreInfoRes mediaStoreInfoRes(FoodaMediaProductDto dto) {
        final FoodaMediaStoreInfoRes mediaStoreInfoRes=new FoodaMediaStoreInfoRes();
        mediaStoreInfoRes.setStoreId(dto.getProductKey().getStoreId());
        // mediaStoreInfoRes.setName(dto.get)
        return mediaStoreInfoRes;
    }

    private FoodaMediaProductInfoRes productInfoRes(FoodaMediaProductDto dto) {
        final FoodaMediaProductInfoRes mediaProductInfoRes=new FoodaMediaProductInfoRes();
        mediaProductInfoRes.setProductId(dto.getProductKey().getProductId());
        return mediaProductInfoRes;
    }

    @Override
    public FoodaMediaProductRes requestToResponse(FoodaMediaProductReq req) {
        final FoodaMediaProductRes mediaProductRes=new FoodaMediaProductRes();
        mediaProductRes.setUrl(req.getUrl());
        mediaProductRes.setProductMediaId(req.getProductMediaId());
        mediaProductRes.setProduct(productInfoRes(req));
        mediaProductRes.setType(mediaTypeRes(req));
        mediaProductRes.setStore(mediaStoreRes(req));
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
    @Override
    public FoodaMediaProductDto requestToDto(FoodaMediaProductReq req) {
        return FoodaMediaProductDto.builder()
                .productKey(productKeyDto(req))
                .productMediaId(req.getProductMediaId())
                .url(req.getUrl())
                .type(mediaTypeDto(req))
                .build();

    }

    private FoodaMediaTypeDto mediaTypeDto(FoodaMediaProductReq req) {
        return FoodaMediaTypeDto.builder()
                .extension(req.getType().getExtension())
                .title(req.getType().getTitle())
                .typeId(req.getType().getTypeId())
                .build();
    }

    private FoodaProductKeyDto productKeyDto(FoodaMediaProductReq req) {
        return FoodaProductKeyDto.builder()
                .productId(req.getProduct().getProductId())
                .storeId(req.getStore().getStore().getStoreId())
                .build();
    }

    @Override
    public FoodaMediaProductDto responseToDto(FoodaMediaProductRes res) {

        return FoodaMediaProductDto.builder()
                .url(res.getUrl())
                .type(mediaTypeDto(res))
                .productMediaId(res.getProductMediaId())
                .productKey(productKeyDto(res))
                .build();
    }
    private FoodaProductKeyDto productKeyDto(FoodaMediaProductRes res) {
        return FoodaProductKeyDto.builder()
                .productId(res.getProduct().getProductId())
                .storeId(res.getStore().getStore().getStoreId())
                .build();
    }
    private FoodaMediaTypeDto mediaTypeDto(FoodaMediaProductRes res) {
        return FoodaMediaTypeDto.builder()
                .extension(res.getType().getExtension())
                .title(res.getType().getTitle())
                .typeId(res.getType().getTypeId())
                .build();
    }

}