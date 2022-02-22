import {REACT_APP_API_ENDPOINT} from "../../constants";

export  const  getCats  = async() =>{
        let result;
        const requestOptions = {
            method: 'GET',
            headers: {'Content-Type': 'application/json'},
        };
        try{
            result = await (await fetch(REACT_APP_API_ENDPOINT + '/cats', requestOptions)).json();
        }catch (e) {
            console.error(e);
            result=[];
        }
        return result
}