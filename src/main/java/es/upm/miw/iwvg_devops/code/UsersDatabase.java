package es.upm.miw.iwvg_devops.code;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class UsersDatabase {

    public Stream<User> findAll() {

        List<Fraction> fractions1 = List.of(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1)
        );
        List<Fraction> fractions2 = List.of(
                new Fraction(2, 1),
                new Fraction(-1, 5),
                new Fraction(2, 4),
                new Fraction(4, 3)
        );
        List<Fraction> fractions3 = List.of(
                new Fraction(1, 5),
                new Fraction(3, -6)
        );
        List<Fraction> fractions4 = List.of(
                new Fraction(2, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions5 = List.of(
                new Fraction(0, 1),
                new Fraction(0, -2),
                new Fraction(0, 3)
        );

        List<Fraction> fractions6 = List.of(
                new Fraction(0, 0),
                new Fraction(1, 0),
                new Fraction(1, 1)
        );

        return Stream.of(
                new User("1", "Oscar", "Fernandez", fractions1),
                new User("2", "Ana", "Blanco", fractions2),
                new User("3", "Oscar", "López", fractions3),
                new User("4", "Paula", "Torres", fractions4),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("6", "Paula", "Torres", fractions6)
        );
    }

    public Stream<String> findUserIdByAnyProperFraction() {
       return findAll()
               .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
               .map(User::getId);
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return findAll()
                .filter(user -> user.getFamilyName().equals(familyName))
                .map(User::getFractions)
                .flatMap(Collection::stream)
                .reduce(new Fraction(), Fraction::multiply);
    }

    public Fraction findFractionDivisionByUserId(String id) {
        return findAll()
                .filter(user -> user.getId().equals(id))
                .map(User::getFractions)
                .flatMap(Collection::stream)
                .reduce(Fraction::divide).orElse(new Fraction(0,0));
    }
}
