import React, { Component } from 'react';
import AppNav from './AppNav';
import Axios from 'axios';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import './App.css';
import { Table,Container,Input,Button,Label, Form} from 'reactstrap';
import { FormGroup} from 'react-bootstrap';

import {Link} from 'react-router-dom';
import Moment from 'react-moment';

class Expsenses extends Component {
    emptyItem = {
        description : '' ,
        expensedate : new Date(),
        id:104,
        location : '',
        category : {id:1235 , categoryName:'transportation'}
    }
    constructor(props){
        super(props)
  
        this.state = { 
          isLoading :false,
          Categories:[],
         Locations:[],
          Expsenses : [],
          date :new Date(),
          item : this.emptyItem
         }
  
        this.handleSubmit= this.handleSubmit.bind(this);
       this.handleChange= this.handleChange.bind(this);
        this.handleDateChange= this.handleDateChange.bind(this);
  
      } 
    async componentDidMount() {
 
        const responsectg=await Axios.get('/api-category/categories'
        );
        this.setState({Categories : await responsectg.data , isLoading :false});

        const responselct=await Axios.get('/api-expense/getAllLocations'
        );
        this.setState({Locations : await responselct.data , isLoading :false});

        const responsexp=await Axios.get('/api-expense/expenses'
        );
        this.setState({Expsenses : await responsexp.data , isLoading :false});
     
  
    }

        async handleSubmit(event){
           console.log("handeSubmit'e girdi")
            const item = this.state.item;
            console.log("item olustu girdi")
      
           
      await fetch(`/api-expense/saveexpense`, {
        method : 'POST',
        headers : {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body : JSON.stringify(item),
      });
      console.log("fetcg girdi")
      event.peventDefault();
      this.props.history.push("/expenses");
                
          }

          handleChange(event){
            const target= event.target;
            const value= target.value;
            const name = target.name;
            let item={...this.state.item};
            item[name] = value;
            this.setState({item});
            console.log(item);
          }
      
      
          handleDateChange(date){
            let item={...this.state.item};
            item.expensedate= date;
            this.setState({item});
          
          }
    async removeExpense(id){
        await fetch(`/api-expense/deleteexpense/${id}` , {
          method: 'DELETE' ,
          headers : {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
          }

        }).then(() => {
          let updatedExpenses = [...this.state.Expsenses].filter(i => i.id !== id);
          this.setState({Expsenses : updatedExpenses});
        });

    }
    
    render() { 
        const title =<h3>Add Expense</h3>;
        const {Categories} =this.state;
        const {Expsenses,isLoading} = this.state;
        const {Locations}=this.state;

        if (isLoading)
            return(<div>Loading....</div>)
         
            let expenserows=
            Expsenses.map( expense =>
              <tr key={expense.id}>
                <td>{expense.description}</td>
                <td>{expense.location}</td>
                <td><Moment date={expense.expensedate} format="YYYY/MM/DD"/></td>
                <td>{expense.category.categoryName}</td>
                <td><Button size="sm" color="danger" onClick={() => this.removeExpense(expense.id)}>Delete</Button></td>
              </tr>)
        let categoryList  =
                Categories.map( (category) =>
                    <option value={category.id} key={category.id}>
                                {category.categoryName} 
                    </option>
                )
                
         let locationList =Locations,
                MakeItem = function(X) {
                    return <option key={locationList.indexOf(X)}>{X}</option>;
                };
              
                
        return ( 
            <div>
            <AppNav/>
            <Container>
                {title}
                
                <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label for="description">Title</Label>
                    <Input type="description" name="description" id="description"  placeholder="with a placeholder"
                        onChange={this.handleChange} autoComplete="name"/>
                
                </FormGroup>

                <FormGroup>
                    <Label for="category" >Category</Label>
                    <select name="select" id="exampleSelect" onChange={this.handleChange} >
                            {categoryList}
                    </select>
                
                </FormGroup>
  
                <FormGroup>
               <Label for="location" >location</Label>
                    <select name="location" id="exampleSelect"  onChange={this.handleChange}>
                    {locationList.map(MakeItem)}
                    </select>
                    </FormGroup> 

                <FormGroup>
                    <Label for="city">Date</Label>
                    <DatePicker    selected={this.state.item.expensedate}  onChange={this.handleDateChange} />
                </FormGroup>

                      
                <FormGroup>
                    <Button color="primary" type="submit">Save</Button>{' '}
                    <Button color="secondary" tag={Link} to="/">Cancel</Button>
                </FormGroup>
                </Form>
            </Container>
           {''}
             <Container>
               <h3>Expense List</h3>
               <Table className="mt-4">
               <thead>
                 <tr>
                   <th width="30%">Description</th>
                   <th width="10%">Location</th>
                   <th> Date</th>
                   <th> Category</th>
                   <th width="10%">Action</th>
                 </tr>
               </thead>
               <tbody>
                  {expenserows}
               </tbody>

               </Table>
             </Container>

         }

       </div>
           );
    }
}
 
export default Expsenses;