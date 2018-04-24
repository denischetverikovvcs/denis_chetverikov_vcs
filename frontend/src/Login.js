import React from 'react';
 
  const Login = () => (
    <div className='login'>
     <form>
       <label>Username</label><br />
       <input name="user"/><br />
       <label>Password</label><br />
       <input name="password"/><br />
     </form>
     <button>
       Submit
     </button>
    </div>
  );

export default Login;