package edu.pucese.ereservation.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pucese.ereservation.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, String> {

}
