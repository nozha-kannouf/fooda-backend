package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaAppReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaAppSourceReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaTypeReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaAppRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaAppSourceRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaTypeRes;

public class FoodaMediaAppHttpMapper implements FoodaHttpMapper<FoodaMediaAppReq, FoodaMediaAppRes> {
    @Override
    public FoodaMediaAppReq responseToRequest(FoodaMediaAppRes foodaMediaAppRes) {
        return FoodaMediaAppReq.builder()
                .appSourceMediaId(foodaMediaAppRes.getAppSourceMediaId())
                .url(foodaMediaAppRes.getUrl())
                .appSource(appSourceReq(foodaMediaAppRes))
                .type(mediaTypeReq(foodaMediaAppRes))
                .build();
    }

    private FoodaMediaTypeReq mediaTypeReq(FoodaMediaAppRes foodaMediaAppRes) {
        return FoodaMediaTypeReq.builder()
                .typeId(foodaMediaAppRes.getType().getTypeId())
                .title(foodaMediaAppRes.getType().getTitle())
                .extension(foodaMediaAppRes.getType().getExtension())
                .build();
    }

    private FoodaMediaAppSourceReq appSourceReq(FoodaMediaAppRes foodaMediaAppRes) {
        return FoodaMediaAppSourceReq.builder()
                .appSourceId(foodaMediaAppRes.getAppSource().getAppSourceId())
                .title(foodaMediaAppRes.getType().getTitle())
                .resolution(foodaMediaAppRes.getAppSource().getResolution())
                .url(foodaMediaAppRes.getUrl())
                .mustBeCached(false)
                .build();
    }

    @Override
    public FoodaMediaAppRes requestToResponse(FoodaMediaAppReq appReq) {
         FoodaMediaAppRes foodaMediaAppRes=new FoodaMediaAppRes();
         foodaMediaAppRes.setAppSourceMediaId(appReq.getAppSourceMediaId());
         foodaMediaAppRes.setUrl(appReq.getUrl());
         foodaMediaAppRes.setAppSource(appSourceRes(appReq));
         foodaMediaAppRes.setType(mediaTypeRes(appReq));
        return foodaMediaAppRes;
    }

    private FoodaMediaTypeRes mediaTypeRes(FoodaMediaAppReq appReq) {
        FoodaMediaTypeRes foodaMediaTypeRes=new FoodaMediaTypeRes();
        foodaMediaTypeRes.setTypeId(appReq.getType().getTypeId());
        foodaMediaTypeRes.setTitle(appReq.getType().getTitle());
        foodaMediaTypeRes.setExtension(appReq.getType().getExtension());
        return foodaMediaTypeRes;
    }

    private FoodaMediaAppSourceRes appSourceRes(FoodaMediaAppReq appReq) {
        FoodaMediaAppSourceRes foodaMediaAppSourceRes=new FoodaMediaAppSourceRes();
        foodaMediaAppSourceRes.setAppSourceId(appReq.getAppSource().getAppSourceId());
        foodaMediaAppSourceRes.setTitle(appReq.getType().getTitle());
        foodaMediaAppSourceRes.setUrl(appReq.getUrl());
        foodaMediaAppSourceRes.setResolution(appReq.getAppSource().getResolution());
        foodaMediaAppSourceRes.setMustBeCached(false);
        return foodaMediaAppSourceRes;
    }
}
