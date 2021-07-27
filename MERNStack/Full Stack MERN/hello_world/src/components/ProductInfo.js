import React, {useEffect, useState} from 'react';
import axios from "axios";

const ProductInfo = (props) => {

    const [product, setProduct] = useState({});

    useEffect(() => {
        axios.get("http://localhost:8000/api/product/" + props.id)
            .then((res) => setProduct(res.data))
            .catch((err) => console.log(err))
    }, [props.id])

    return (
        <div className={"m-5 p-5"}>
            <h1>{product.title}</h1>
            <h3>Price: {product.price}$</h3>
            <h3>Description: {product.description}</h3>
        </div>
    )

}

export default ProductInfo;