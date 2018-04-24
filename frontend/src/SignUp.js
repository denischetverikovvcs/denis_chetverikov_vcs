import React, {Component} from 'react';

 class SignUp extends Component{
   constructor(props){
    super(props);
    this.state={
    username:''
      
    };
    this.state={
    email:''
    };
    this.state={
      password:''
      };

    this.handleEmailChange=this.handleEmailChange.bind(this);
    this.handleSubmit=this.handleSubmit.bind(this);

    }

    


handleSubmit=(event) => {
  event.preventDefault();
  console.log('form is submitted.  Username value is', this.state.username,'Password is', this.state.password,'Email value is',
   this.state.email);
}
handleEmailChange=(event) => {
  console.log('email was changed', event.target.value);
  this.setState({email:event.target.value});
}
handleUserNameChange=(event)=>{
    console.log('username was changed', event.target.value);
    this.setState({username:event.target.value});
  }
  handlePasswordChange=(event)=>{
    console.log('password was changed', event.target.value);
    this.setState({password:event.target.value});
  }

// const SignUp = () => (
//     <div className='Signup'>

//     <form >
//     <label>Username</label><br />
//     <input name="username" placeholder="username"/><br /> 
       
//     <label>Password</label><br />
//     <input name="password" placeholder="password"/><br />
//     <label>E-mail address</label><br />
//     <input name="email" placeholder="E-mail"/><br />
    
//     <button>SignUp</button>
//     </form>
//     </div>
// );
  render(){
    return (
      <form onSubmit={this.handleSubmit}>
      <label>Username</label><br />
   <input name="username" placeholder="username" value={this.state.username} onChange={this.handleUserNameChange}/><br />
<label>Password</label><br />
    <input name="password" placeholder="password" value={this.state.password} onChange={this.handlePasswordChange}/><br />
    <label>E-mail address</label><br />
      <input name="email" placeholder="E-mail" value={this.state.email}
      onChange={this.handleEmailChange}
      />
      <button>SignUp</button>
      </form>
    );
  }
}
export default SignUp; 