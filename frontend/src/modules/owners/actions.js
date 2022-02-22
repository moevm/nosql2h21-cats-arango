import {REACT_APP_API_ENDPOINT} from "../../constants";

export  const  getOwners  = async() =>{
    let result;
    const requestOptions = {
        method: 'GET',
        headers: {'Content-Type': 'application/json'},
    };
    try{
        result = await (await fetch(REACT_APP_API_ENDPOINT + '/owners', requestOptions)).json();
    }catch (e) {
        console.error(e);
        result=[];
    }
    return result;

}


export  const  addOwner  = async(body) =>{
    let result;
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
    };
    try{
        result = await (await fetch(REACT_APP_API_ENDPOINT + '/owners', {...requestOptions, body:JSON.stringify(body)})).json();
    }catch (e) {
        console.error(e);
        result=[];
    }
    return result

}