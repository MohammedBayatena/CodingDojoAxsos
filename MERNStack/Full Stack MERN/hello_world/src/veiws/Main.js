import React, {useState} from 'react';
import {Router} from "@reach/router";
import ProductInfo from "../components/ProductInfo";
import MainView from "../components/MainView";
import UpdateProduct from "../components/UpdateProduct";

export default () => {

    return (
        <div>
            <Router>
                <MainView path={"/api/product/"}/>
                <ProductInfo path={"/api/product/:id"}/>
                <UpdateProduct path={"/api/product/:id/edit"}/>
            </Router>
        </div>
    )
}