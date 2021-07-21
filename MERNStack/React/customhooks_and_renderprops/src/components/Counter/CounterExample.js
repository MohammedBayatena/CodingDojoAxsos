// FirstCounter.js
import React from 'react';

import Counter from './Counter';

export default () => (
    <Counter
        initialCount={0} // pass the initial value
        render={({count, increment}) => ( // The render = what the the Counter component will return ,its being deconstructed in case of variables and its body is written here
            <>
                <h2>The count is currently {count}!</h2>
                <button onClick={increment}>Add One</button>
            </>
        )}
    />
)