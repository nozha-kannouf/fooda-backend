package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaStoreReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaStoreRes;

public class FoodaMediaStoreHttpMapper implements FoodaHttpMapper<FoodaMediaStoreReq, FoodaMediaStoreRes> {
    @Override
    public FoodaMediaStoreReq responseToRequest(FoodaMediaStoreRes foodaMediaStoreRes) {
        return null;
    }

    @Override
    public FoodaMediaStoreRes requestToResponse(FoodaMediaStoreReq foodaMediaStoreReq) {
        return null;
    }
}
