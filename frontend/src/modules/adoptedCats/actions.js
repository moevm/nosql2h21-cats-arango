import {REACT_APP_API_ENDPOINT} from "../../constants";

export  const  getAdoptedCats  = async() =>{
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
    return result

}