import React, {useState} from 'react';
import {Router} from "@reach/router";
import ProductInfo from "../components/ProductInfo";
import MainView from "../components/MainView";

export default () => {

    return (
        <div>
            <Router>
                <MainView path={"/api/product/"}/>
                <ProductInfo path={"/api/product/:id"}/>
            </Router>
        </div>
    )
}