import React, {useState} from 'react';
import ProductForm from "./ProductForm";
import ProductsList from "./ProductsList";
import MyContext from "../contexts/RefreshContext";
import axios from "axios";

const MainView = () => {

    const [refresh, setRefresh] = useState(false)
    const createProduct = product => {
        axios.post('http://localhost:8000/api/product/new', product)
            .then(res => {
                console.log(res);
                setRefresh(true)
            })
            .catch(err => console.log(err))
    }

    return (
        <MyContext.Provider value={{refresh, setRefresh}}>
            <h1>Add a Product</h1>
            <ProductForm initialtitle={""} initialprice={0} initialdescription={""} buttontext={"Add Product"}
                         onSubmitProp={createProduct}/>
            <hr/>
            <h1>All Products:</h1>
            <ProductsList/>
        </MyContext.Provider>
    )

};

export default MainView;