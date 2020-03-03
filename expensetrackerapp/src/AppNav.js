import React, { Component } from "react";
import { Navbar, Nav, NavDropdown, Form,  FormControl, Button, Table} from 'react-bootstrap';


class AppNav extends Component {
    state = {  }
    render() {
        return (
          <>
          <Navbar bg="dark" variant="dark">
          <Navbar.Brand href="#home">Expense Tracker</Navbar.Brand>
          <Nav className="mr-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="/categories">Categories</Nav.Link>
            <Nav.Link href="/expenses">Expenses</Nav.Link>
          </Nav>
          <Form inline>
            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
            <Button variant="outline-info">Search</Button>
          </Form>
        </Navbar>
       
        </>
        );
      }
}
 
export default AppNav;