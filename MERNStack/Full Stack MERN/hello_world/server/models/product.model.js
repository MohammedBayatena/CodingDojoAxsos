const mongoose = require("mongoose");

const ProductSchema = new mongoose.Schema(
    {
        title: {
            type: String,
            required: [true, "Title is required"],
            minlength: [3, "Title should be  at least 3 characters in length"]
        },
        price: {
            type: Number,
            required: [true, "Price is required"],
            min: [1, "Price Should be at least 1 Dollar"]
        },
        description: {
            type: String,
            required: [true, "Description is required"],
            minlength: [10, "Description should be  at least 10 characters in length"]
        }
    }, {timestamps: true}
);

module.exports.Product = mongoose.model('Product', ProductSchema);