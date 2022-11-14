import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {
  constructor(private httpClient: HttpClient) {}

  get(): Observable<Student[]> {
    return this.httpClient.get<Student[]>('http://localhost:8080/students');
  }

  create(payload: Student) {
    return this.httpClient.post<Student>(
      'http://localhost:8080/students',
      payload
    );
  }

  getById(id: number): Observable<Student> {
    return this.httpClient.get<Student>(`http://localhost:8080/students/${id}`);
  }

  update(payload: Student): Observable<Student> {
    return this.httpClient.put<Student>(
      `http://localhost:8080/students/${payload.id}`,
      payload
    );
  }

  delete(id: number) {
    return this.httpClient.delete(`http://localhost:8080/students/${id}`);
  }
}
