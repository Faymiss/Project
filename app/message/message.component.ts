// message.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-message',
    templateUrl: './message.component.html',
    styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
    queryParams: any;

    constructor(private route: ActivatedRoute) {}

    ngOnInit() {
        this.queryParams = this.route.snapshot.queryParams;
    }
}
