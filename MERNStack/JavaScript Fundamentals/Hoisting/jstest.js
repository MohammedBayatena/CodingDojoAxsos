//---------------------------------------------1-----------------------------------
    /*
    console.log(hello);                                   
    var hello = 'world'; 
    */
//1)Var hello;
//2)console.log(hello);
//3)hello = 'world';
//Guess : Prints Undifined  (Correct)

//---------------------------------------------2-----------------------------------
    /*
        var needle = 'haystack';
        test();
        function test(){
            var needle = 'magnet';
            console.log(needle);
        }
    */
/**
 * 1) var needle;
 * 2)function test{
 * 3)var needle;
 * 4)needle = magnet
 * 5)console.log(needle) -- >magnet
 * }
 * needle=haystack
 */
//Guess : prints Magnet (Correct)

//---------------------------------------------3-----------------------------------
/**
    var brendan = 'super cool';
    function print(){
        brendan = 'only okay';
        console.log(brendan);
    }
    console.log(brendan);
 */


/**
 * 1)var brendan;
 * 2)brendan = super cool;
 * 3)function print(){
 * 4)brendan = only okay
 * 5)console.log(brendan); 
 * }
 * 6)console.log(brendan); -- > super cool (Function not called)
 */
// guess : super cool
//---------------------------------------------4-----------------------------------
/*
    var food = 'chicken';
    console.log(food);
    eat();
    function eat(){
        food = 'half-chicken';
        console.log(food);
        var food = 'gone';
    }
*/

/**
 * 
 * 1)var food;
 * 2)food = chicken;
 * 3)console.log(food); -- chicken
 * 4)function eat(){
 * 5)var food;
 * 6)food = 'half-chicken';
 * 7)console.log(food); -- 'half-chicken'
 * 8)food = gone
 * }
 */

//guess : chicken , half-chicken
//---------------------------------------------5-----------------------------------
/*
    mean();  // mean is defined with a ()=) hence it acts like an anchor and the line doesnt get hoisted , but stays in position
    console.log(food);
    var mean = function() {
        food = "chicken";
        console.log(food);
        var food = "fish";
        console.log(food);
    }
    console.log(food);
*/
//Error : mean is not a function
//---------------------------------------------6-----------------------------------
    /*
        console.log(genre);
        var genre = "disco";
        rewind();
        function rewind() {
            genre = "rock";
            console.log(genre);
            var genre = "r&b";
            console.log(genre);
        }
        console.log(genre);
    */

/**
 * 1)var genre;
 * 2)console.log(genre); -- Undefined
 * 3)genre = disco 
 * 4)function rewind(){
 * 5)var genre;
 * 6)genre = rock;
 * 7)console.log(genre); -- rock
 * 8)genre = r&b
 * 9)console.log(genre); -- r&b
 * }
 * 10)console.log(genre); -- dsico
 */
// Guess : Undefined,rock,r&b,disco

//---------------------------------------------7-----------------------------------
/*
    dojo = "san jose";
    console.log(dojo);
    learn();
    function learn() {
        dojo = "seattle";
        console.log(dojo);
        var dojo = "burbank";
        console.log(dojo);
    }
    console.log(dojo);
*/

/**
 * 1)dojo = "san jose" //-- Means the same as var dojo = san jose;
 * 2)console.log(dojo); -- san jose
 * 3)fucntion learn() {
 * 4)var dojo;
 * 5)dojo = seattle;
 * 6)console.log(dojo); -- seatle
 * 7)dojo = burbank;
 * 8)console.log(dojo); -- burbank
 * )} 
 * 9)console.log(dojo); -- san jose
 */

//Guess : san jose , seatle , burbank , san jose

//---------------------------------------------8-----------------------------------

console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students){
    const dojo = {};
    dojo.name = name;
    dojo.students = students;
    if(dojo.students > 50){
        dojo.hiring = true;
    }
    else if(dojo.students <= 0){
        dojo = "closed for now";
    }
    return dojo;
}

/**
 * 1)function makeDojo(name, students){
 * 2)var name = name;
 * 3)var students = students;
 * 4)const dojo = {};
 * 5)dojo.name = name
 * 6)dojo.students = students
 * 7) if (dojo.students  > 50 ){
 * 8)dojo.hiring  = true;
 * 9)}else if (dojo.students < = 0){
 * 10)dojo = "colsed for now" -- Trying to set a value for the const variable that is in the top , will not be allowed
 * )}
 * 11)return dojo;
 * )}
 * 12)console.log(makeDojo("Chicago", 65));
 * 13)console.log(makeDojo("Berkeley", 0));
 */

//Guess : Error Cant assign a value top a static field