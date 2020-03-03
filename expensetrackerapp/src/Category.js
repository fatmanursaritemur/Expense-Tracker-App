import React, { Component } from 'react';
import Axios from 'axios';
import AppNav from './AppNav';
import { Table,Container,Input,Button,Label, Form} from 'reactstrap';

class Category extends Component {

    state = {  
        isLoading : true,
        Categories : []
    }
 
    async componentDidMount(){
        const response=await Axios.get('/api-category/categories'
          );
      
          let responseOK = response && response.status === 200 && response.statusText === 'OK';
          if (responseOK) {
        this.setState({Categories : await response.data , isLoading: false});
          }
    }

    render() { 
        const {Categories , isLoading} = this.state;
        let categoryerows=
        Categories.map( category =>
          <tr key={category.id}>
            <td>{category.categoryName}</td>
          </tr>)
        return ( 
            
            <div>
            <AppNav/>
            <Container>
               <h3>Category List</h3>
               <Table className="mt-4">
               <thead>
                 <tr>
                   <th width="30%">Category Name</th>
                 </tr>
               </thead>
               <tbody>
                  {categoryerows}
               </tbody>

               </Table>
             </Container>
                

                </div>
         );
    }
}
 
export default Category;