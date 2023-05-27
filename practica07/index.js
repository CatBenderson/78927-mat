function buscar(int){
    axios({
        method: "GET",
        url: 'https://swapi.dev/api/species/'+int,
    }).then((res) => {
        console.log(int)
        console.log(res)
        document.getElementById("nombre").innerHTML=res.data.name
        document.getElementById("clasificacion").innerHTML=res.data.classification
        document.getElementById("altura").innerHTML=res.data.average_height
        document.getElementById("vida").innerHTML=res.data.average_lifespan
        document.getElementById("lenguaje").innerHTML=res.data.language
        document.getElementById("hogar").innerHTML=res.data.homeworld
        document.getElementById("hogar").href=res.data.homeworld
    }).catch(error => {
        console.log(error);
        throw new Error(error);
    });
}