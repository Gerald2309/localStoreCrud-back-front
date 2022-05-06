import React from 'react';
import { TodoContext } from '../TodoContext';
import './TodoForm.css';
import { useForm } from "react-hook-form";

function TodoForm() {
  const { register, handleSubmit, formState: { errors } } = useForm();
  const [newTodoValue, setNewTodoValue] = React.useState('');
  const {
    addTodo,
    setOpenModal,
  } = React.useContext(TodoContext);
  
  const onChange = (event) => {
    setNewTodoValue(event.target.value);
  };
  const onCancel = () => {
    setOpenModal(false);
  };
  const onSubmit = () => {
  
    addTodo(newTodoValue);
    setOpenModal(false);
  };

  return (
    <form onSubmit={handleSubmit (onSubmit)}>
      <label>Escribe tu nueva tarea</label>
      <textarea
        {...register("required", { required: true })}
        value={newTodoValue}
        onChange={onChange}
        placeholder="Cortar la cebolla para el almuerzo"
      />
      <div>
      {errors.required && <span className="error">Este campo es requerido</span>}
      </div>
      <div className="TodoForm-buttonContainer">
        <button
          type="button"
          className="TodoForm-button TodoForm-button--cancel"
          onClick={onCancel}
          >
          Cancelar
        </button>
        <button
          type="submit"
          className="TodoForm-button TodoForm-button--add"
        >
          Añadir
        </button>
      </div>
    </form>
  );
}

export { TodoForm };
