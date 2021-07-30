import React, {useEffect, useState} from 'react';
import axios from "axios";
import {navigate} from "@reach/router";
import ProductForm from "./ProductForm";

const UpdateProduct = (props) => {

    const [product, setProduct] = useState({});
    const [loaded, setLoaded] = useState(false);
    const {id} = props;

    useEffect(() => {
        axios.get('http://localhost:8000/api/product/' + id)
            .then(res => {
                setProduct(res.data);
                setLoaded(true);
            })
    }, [])

    const updateProduct = person => {
        axios.put(`http://localhost:8000/api/product/${props.id}/edit`, person)
            .then(result => {
                console.log("{ Status OK }")
                navigate("/api/product/")
            })
            .catch(err => console.log(err))
    }

    return (
        loaded && (
            <ProductForm buttontext={"Update"} initialtitle={product.title} initialprice={product.price}
                         initialdescription={product.description}
                         onSubmitProp={updateProduct}/>
        )
    )
}

export default UpdateProduct;