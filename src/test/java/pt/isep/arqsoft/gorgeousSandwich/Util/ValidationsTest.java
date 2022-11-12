package pt.isep.arqsoft.gorgeousSandwich.Util;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsTest {


    private static final int[] NUMS = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final String[] STRS = {null, null, "", "", "a", "s", "", "", null, null};


    @Test
    void numberIsBetween() {
        for (int i : NUMS) {
            try {
                Validations.numberIsInBetween(i, 3, 6);
                if (i < 3 || i > 6) {
                    fail(Integer.toString(i));
                }
            } catch (ValidationException e) {
                if (i >= 3 && i <= 6) {
                    fail(Integer.toString(i));
                }
            }
        }


    }

    @Test
    void numberIsGreater() {
        for (int i : NUMS) {
            try {
                Validations.numberIsGreater(i, 2);
                if (i <= 2) {
                    fail(Integer.toString(i));
                }
            } catch (ValidationException e) {
                if (i > 2) {
                    fail(Integer.toString(i));
                }
            }
        }
    }

    @Test
    void numberIsEqual() {
        for (int i : NUMS) {
            try {
                Validations.numberIsEqual(i, 3);
                if (i != 3) {
                    fail(Integer.toString(i));
                }
            } catch (ValidationException e) {
                if (i == 3) {
                    fail(Integer.toString(i));
                }
            }
        }
    }

    @Test
    void numberIsLower() {
        for (int i : NUMS) {
            try {
                Validations.numberIsLower(i, 5);
                if (i >= 5) {
                    fail(Integer.toString(i));
                }
            } catch (ValidationException e) {
                if (i < 5) {
                    fail(Integer.toString(i));
                }
            }
        }
    }

    @Test
    void numberIsPositive() {
        for (int i : NUMS) {
            try {
                Validations.numberIsPositive(i);
                if (i <= 0) {
                    fail(Integer.toString(i));
                }
            } catch (ValidationException e) {
                if (i > 0) {
                    fail(Integer.toString(i));
                }
            }
        }
    }

    @Test
    void numberIsNegative() {
        for (int i : NUMS) {
            try {
                Validations.numberIsNegative(i);
                if (i >= 0) {
                    fail(Integer.toString(i));
                }
            } catch (ValidationException e) {
                if (i < 0) {
                    fail(Integer.toString(i));
                }
            }
        }
    }

    @Test
    void numberIsNonPositive() {
        for (int i : NUMS) {
            try {
                Validations.numberIsNonPositive(i);
                if (i > 0) {
                    fail(Integer.toString(i));
                }
            } catch (ValidationException e) {
                if (i <= 0) {
                    fail(Integer.toString(i));
                }
            }
        }
    }

    @Test
    void numberIsNonNegative() {
        for (int i : NUMS) {
            try {
                Validations.numberIsNonNegative(i);
                if (i < 0) {
                    fail(Integer.toString(i));
                }
            } catch (ValidationException e) {
                if (i >= 0) {
                    fail(Integer.toString(i));
                }
            }
        }
    }

    @Test
    void notAnyNull() {
        try {
            Validations.notAnyNull(((Object[]) STRS));
            fail("Should have failed");
        } catch (ValidationException e) {

        }
    }

    @Test
    void notNull() {
        for (String str : STRS) {
            try {
                Validations.notNull(str);
                if (str == null) {
                    fail("String was marked as null yet did not get flagged");
                }
            } catch (ValidationException e) {
                if (str != null) {
                    fail("String was not null but was marked as null");
                }
            }
        }
    }

    @Test
    void notEmpty() {
        for (String str : STRS) {
            try {
                Validations.notEmpty(str);
                if (str == null || str.isEmpty()) {
                    fail("String was empty yet did not get flagged");
                }
            } catch (ValidationException e) {
                if (str != null && !str.isEmpty()) {
                    fail("String was not empty but was marked as such");
                }
            }
        }
    }

    @Test
    void notAnyEmpty() {
        try {
            Validations.notAnyEmpty(STRS);
            fail("Should have failed");
        } catch (ValidationException e) {

        }
    }

    @Test
    void matchesRegex() {
        for (String str : STRS) {
            try {
                Validations.matchesRegex(str, "a");
                if (str == null || !str.equals("a")) {
                    fail(String.format("String %s should have been flaged but was not!", str));
                }
            } catch (ValidationException e) {
                if (str != null && str.equals("a")) {
                    fail(String.format("String %s should have not been flaged but was!", str));
                }
            }
        }

        try {
            Validations.matchesRegex("a", null);
            fail("Should have failled");
        } catch (ValidationException e) {
            try {
                Validations.matchesRegex("a", "");
                fail("Should have failed");
            } catch (ValidationException ignored) {
            }
        }


    }
}