import {REACT_APP_API_ENDPOINT} from "../../constants";

export  const  getCats  = async() =>{
        let result;
        const requestOptions = {
            method: 'GET',
            headers: {'Content-Type': 'application/json'},
        };
        try{
            result = await (await fetch(REACT_APP_API_ENDPOINT + '/homeless', requestOptions)).json();
        }catch (e) {
            console.error(e);
            result=[];
        }
        console.log(result);
        return result
}

export  const  addCat  = async(body) =>{
    let result;
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
    };
    try{
        console.log(body, JSON.stringify(body));
        result = await (await fetch(REACT_APP_API_ENDPOINT + '/cats', {...requestOptions, body:JSON.stringify(body)})).json();
    }catch (e) {
        console.error(e);
        result=[];
    }
    return result
}

export  const  updateCat  = async(body) =>{
    let result;
    const requestOptions = {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
    };
    try{
        console.log(body, JSON.stringify(body));
        result = await (await fetch(REACT_APP_API_ENDPOINT + '/cats', {...requestOptions, body:JSON.stringify(body)})).json();
    }catch (e) {
        console.error(e);
        result=[];
    }
    return result

}

export  const  adoptCat  = async(body) =>{
    let result;
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
    };
    try{
        result = await (await fetch(REACT_APP_API_ENDPOINT + '/cats/adopt', {...requestOptions, body:JSON.stringify(body)})).json();
    }catch (e) {
        console.error(e);
        result=[];
    }
    return result

}