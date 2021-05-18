 $(document).ready(function(){
        //attach a click event listener to all the img tags when the document is ready
            $('#add2').click(function(){
                document.location.href="/incrementby2";
            });

             $('#reset').click(function(){
                console.log("Did reset")
                document.location.href="/destroy_session";
            });
        });