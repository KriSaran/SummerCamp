import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute,  NavigationEnd, Router } from '@angular/router';
import { ForgotpasswordService } from '../forgotpassword.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent  implements OnInit{

 private token = '';
//  accessToken :string | undefined;
resetPasswordForm!: FormGroup;

submitted = false;
  user: any;
  toastr: any;

constructor(private http: HttpClient,private route:Router,private forgotPasswordService : ForgotpasswordService){
     route.events.subscribe(s=>{
      if(s instanceof NavigationEnd){
        let url = s.url;
        console.log(url + "," + url.indexOf('token='));
        if (url.indexOf('token=')!=-1) {
          let token = url.substring(url.indexOf('token=')+'token='.length);
          console.log(token);
          this.token=token;
        }
      }
     });
  
 }

ngOnInit(): void {

  this.forgotPasswordService.getUserName(this.token).subscribe( data => {
    this.user = data;
  });
 
  this.resetPasswordForm = new FormGroup({
    password : new FormControl('', [
      Validators.required
      // Validators.minLength(8),
      // Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)
  ])
 
  });

}

get f() {
  return this.resetPasswordForm.controls;
}

onSubmit() {

  this.submitted = true;

  if (this.resetPasswordForm.invalid) {
    // Displaying error message
    console.error("Unsuccessful request");
  }


  const password = this.resetPasswordForm.value.password;
  const token = this.token;
  console.log(token);
  // this.forgotpassword.getForgotPassword(email).subscribe((response: any) => {
  this.http.post('http://localhost:8080/api/reset-password', { password:password, token:this.token}).subscribe((response) => {
    //  this.toastr.info('Successfully updated the password');
     console.log('Password reset success');
    //  this.resetPasswordForm.value.password('');
    // display a success message to the user
  }, (error: any) => {
    console.error('Failed to send update password request:', error);
    // this.toastr.info('Failed to update the password:',error);

    // display an error message to the user
  });
}
}
