import {useState} from "react";

// This Component is a generic counter , it have its own counter state and a counter increment ands decrement methods
// THis Component can be used by other components of the same type
// This component takes the initial count from other components and a render function which will
// be returned full with the count and increment and decrement functions

export default ({initialCount = 0, render}) => {

    const [count, setCount] = useState(initialCount);
    const increment = () => setCount(count + 1);
    const decrement = () => setCount(count - 1);

    return render({count, increment, decrement});


}