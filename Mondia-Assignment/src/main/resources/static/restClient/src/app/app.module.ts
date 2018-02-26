import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes, Route } from '@angular/router';
import { ProductService } from './shared-service/product.service';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { ListproductComponent } from './components/listproduct/listproduct.component';
import { ProductFormComponent } from './components/product-form/product-form.component';

const appRoutes: Routes = [
  { path: '', component: ListproductComponent },
  { path: 'op', component: ProductFormComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    ListproductComponent,
    ProductFormComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
