import { Component, OnInit } from '@angular/core';
import { Product } from '../../product';
import { Router } from '@angular/router';
import { ProductService } from '../../shared-service/product.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  private product: Product;

  constructor(private _productService: ProductService, private _router: Router) { }

  ngOnInit() {
    this.product = this._productService.getter();
  }

  processForm(){
    if(this.product.id==undefined){
       this._productService.createProduct(this.product).subscribe((product)=>{
         console.log(product);
         this._router.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }else{
       this._productService.updateProduct(this.product).subscribe((product)=>{
         console.log(product);
         this._router.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }
  }

}
