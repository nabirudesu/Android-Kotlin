var express = require("express");
var mysql = require("mysql");
var bodyparser= require('body-parser')
var app = express();

app.use(bodyparser.json())


// par défaut le mot de passe est ''
var connection = mysql.createConnection({
    host     :'localhost',
    user     : 'root',
    password : '',
    database:  'db',
    port: 3308
});
connection.connect();


app.get('/getMoveisNames',function(req,res){  
    var query = "select title from moveis";
    connection.query(query,function(error,results){
    if (error) { throw(error) }
    res.send(JSON.stringify(results));
})
});
app.get('/getactorsbymovie/:title',function(req,res){  
    var query = "select ac.* from moveis mv INNER JOIN actormovie mcv ON mcv.id_movie=mv.id_movie INNER JOIN actors ac ON mcv.id_actor=ac.id_actor WHERE title=?";
    connection.query(query,[req.params.title],function(error,results){
    if (error) { throw(error) }
    res.send(JSON.stringify(results));
})
});

app.post('/addactor',function(req,res){
    var actor = req.body
    var query = "insert into actors (id_actor,firstname,lastname,gender) values (?,?,?,?)"
    connection.query(query,[actor.id_actor,actor.firstname,actor.lastname,actor.gender],function(error,results){
        if (error) { throw(error) }
    res.send(JSON.stringify('results'));
    })

});
//select * from actors WHERE id_actor in (select id_actor from actorsmovies WHERE id_movie in (selesct id_movie from moveis WHERE title=? ))
//select * from moveis mv INNER JOIN actormovie mcv ON mcv.id_movie=mv.id_movie INNER JOIN actors ac ON mcv.id_actor=ac.id_actor WHERE title=?
var server = app.listen(8082,function(){
    var host = server.address().address
    var port = server.address().port
});


